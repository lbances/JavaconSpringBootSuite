package edu.idat.pe;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.comercio.sw.Estado;
import com.comercio.sw.GetCodigoRequest;
import com.comercio.sw.GetCodigoResponse;
import com.comercio.sw.GuardarProductoRequest;
import com.comercio.sw.GuardarProductoResponse;
import com.comercio.sw.Producto;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Endpoint
public class PuntosAcceso {
	
	private static final String url="http://comercio.com/sw";
	private ServicioProducto sp;
	
	@Autowired
	public PuntosAcceso(ServicioProducto sp) {
		this.sp = sp;
	}
	
	@PayloadRoot(namespace = url, localPart = "getCodigoRequest")
	@ResponsePayload
	public GetCodigoResponse BuscarProducto(@RequestPayload GetCodigoRequest peticion) {
		GetCodigoResponse ob = new GetCodigoResponse();
		CProducto cproducto = sp.buscarcodigo(peticion.getCodigo());
		Producto eproducto = new Producto();
		BeanUtils.copyProperties(cproducto, eproducto);
		ob.setProducto(eproducto);
		return ob;
	}
	
	@PayloadRoot(namespace = url, localPart = "GuardarProductoRequest")
	@ResponsePayload
	public GuardarProductoResponse GuardarProducto(@RequestPayload GuardarProductoRequest peticion) {
		GuardarProductoResponse ob = new GuardarProductoResponse();
		CProducto cproducto = new CProducto(peticion.getCodpro(), peticion.getCodcat(), peticion.getDespro(), peticion.getUnipro(), peticion.getPcopro(), peticion.getPvepro(),
											peticion.getStopro(), peticion.getFrepro());
		Estado estado = new Estado();
		Producto eproducto = new Producto();
		
		CProducto guardarp = null;
		try {
			guardarp = sp.guardarproducto(cproducto);
			if(guardarp == null) {
				estado.setCodigo("ERROR");
				estado.setMensaje("ERROR AL REGISTRAR DATOS DEL PRODUCTO");
			}
			else {
				BeanUtils.copyProperties(guardarp, eproducto);
				estado.setCodigo("EXITO");
				estado.setMensaje("SE REGISTRARON CORRECTAMENTE LOS DATOS DEL PRODUCTO");
			}
		} catch (Exception e) {
			estado.setCodigo("FALLO");
			estado.setMensaje("NO SE ENVIARON LOS DATOS DE LOS PARAMETROS DE FORMA CORRECTA");
		}
		ob.setEstado(estado);
		ob.setProducto(eproducto);
		return ob;
	}

}
