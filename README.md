# CURRENCY APP - ANGULAR

#### **1.  Docker Image**
I build the image docker: docker build -t ernestoagc/currency-app:0.1 .

#### **2. Running frontend application**
I going to use a docker container, to create this we can do with this command:
docker run -p 8082:80 -d  --network currency-net  --name=app-currency ernestoagc/currency-app:0.1

Finally, we can use the application with the url: http://localhost:8082/

![](https://i.imgur.com/K8pSHkj.jpg)

