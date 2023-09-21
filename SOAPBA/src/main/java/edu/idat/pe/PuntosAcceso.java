package edu.idat.pe;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.facultadbances.sw.Estado;
import com.facultadbances.sw.Facultad;
import com.facultadbances.sw.GetCodigoRequest;
import com.facultadbances.sw.GetCodigoResponse;
import com.facultadbances.sw.GuardarFacultadRequest;
import com.facultadbances.sw.GuardarFacultadResponse;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Endpoint
public class PuntosAcceso {

	private static final String url="http://facultadbances.com/sw";
	private ServicioFacultad sf;
	
	@Autowired
	public PuntosAcceso(ServicioFacultad sf) {
		super();
		this.sf = sf;
	}
	
	@PayloadRoot(namespace = url, localPart = "getCodigoRequest")
	@ResponsePayload
	public GetCodigoResponse BuscarFacultad(@RequestPayload GetCodigoRequest peticion) {
		GetCodigoResponse ob = new GetCodigoResponse();
		CFacultad cfacultad = sf.buscarcodigo(peticion.getCodigo());
		Facultad efacultad = new Facultad();
		BeanUtils.copyProperties(cfacultad, efacultad);
		ob.setFacultad(efacultad);
		return ob;
	}
	
	@PayloadRoot(namespace = url, localPart = "GuardarProductoRequest")
	@ResponsePayload
	public GuardarFacultadResponse GuardarProducto(@RequestPayload GuardarFacultadRequest peticion) {
		GuardarFacultadResponse ob = new GuardarFacultadResponse();
		CFacultad cfacultad = new CFacultad(peticion.getCodFacultad(), peticion.getDesFacultad());
		
		Estado estado = new Estado();
		Facultad efacultad = new Facultad();
		
		CFacultad guardarp = null;
		try {
			guardarp = sf.guardarproducto(cfacultad);
			if(guardarp == null) {
				estado.setCodigo("ERROR");
				estado.setMensaje("ERROR AL REGISTRAR DATOS DEL FACULTAD");
			}
			else {
				BeanUtils.copyProperties(guardarp, efacultad);
				estado.setCodigo("EXITO");
				estado.setMensaje("SE REGISTRARON CORRECTAMENTE LOS DATOS DE LA FACULTAD");
			}
		} catch (Exception e) {
			estado.setCodigo("FALLO");
			estado.setMensaje("NO SE ENVIARON LOS DATOS DE LOS PARAMETROS DE FORMA CORRECTA");
		}
		ob.setEstado(estado);
		ob.setFacultad(efacultad);
		return ob;
	}
	
}
