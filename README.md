Monsternomicon

Para iniciar la aplicación clonar el repositorio, hacer maven install para crear los ficheros .jar si no estan ya creados.
Desde la linea de comandos situarse en la carpeta del proyecto donde se encuentra el fichero docker compose y lanzar el siguiente comando:  -docker-compose up
Para comprobar que todo ha funcionado correctamente ir a http://localhost:8761/ donde veremos el menú de Eureka Discovery, desde aquí podemos ver que microservicios se han iniciado y cuantas replicas tenemos.
Endpoints de interes:
  - http://localhost:8084/routes, nos muestra las rutas de acceso de Zuul, nuestro proxy inverso.
  - http://localhost:8084/monsternomicon/catalog/monster, la puerta de entrada a la aplicación donde veremos todos los items que hay en la   base de datos.
  - http://localhost:8084/monsternomicon/catalog/monster/{name}, para ver la información detalla del item que queremos ver.
  - http://localhost:8090/hystrix, para ver el Dashboard de hystrix, en este menu podremos visualizar las métricas de nuestros servicios.
  Por ejemplo si ponemos http://monstercatalog:8081/hystrix.stream veremos las métricas para el servicio de catalogo.
  - http://localhost:8084/monsternomicon/monster: en este endpoint podremos hacer tanto peticiones Post como Delete para insertar,           actualizar o borrar items.
Para detener la aplicación nos servira con salir de la consola de comandos haciendo control+c, pero se recomienda lanzar el comando -------docker-compose down a continuación para eliminar los contenedores y la red virtual que hemos creado anteriormente. Para mayor seguridad lanzar el comando -docker system prune (pero con cuidado, este comando borra absolutamente todas las imagenes y contenedores docker que tengamos en la máquina) para asegurarnos que no dejamos ninguna huella al cerrar la aplicación
