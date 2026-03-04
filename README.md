# ApiRest_Productos


#Crear un producto
Método: POST
http://localhost:8080/api/products
{
    "name": "Teclado Mecánico",
    "description": "Teclado RGB switches azules",
    "price": 85.99,
    "stock": 10
}
Listar todos GET

Método: GET
URL: http://localhost:8080/api/products

Obtener por ID
Método: GET
URL: http://localhost:8080/api/products/1

Actualizar PUT

Método: PUT
URL: http://localhost:8080/api/products/1

{
    "name": "Teclado Mecánico Pro",
    "description": "Versión actualizada",
    "price": 99.99,
    "stock": 15
}

Eliminar
Método: DELETE
URL: http://localhost:8080/api/products/1
