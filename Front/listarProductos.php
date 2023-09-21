<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Productos</title>
</head>
<body>
    <form name="frmlistarproductos" method="post" action="listarProductos.php">
        <table align="center">
            <tr>
                <td>Fecha Inicial:</td>
                <td><input type="date" name="txtDesde" required autocomplete="off"/></td>
            </tr>
            <tr>
                <td>Fecha Final:</td>
                <td><input type="date" name="txtHasta" required autocomplete="off"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="btnListar" value="Listar productos"/></td>
            </tr>
        </table>
    </form>

</body>
</html>