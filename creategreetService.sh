docker build -t maduraherath/greet-service:0.0.7 .
docker push maduraherath/greet-service:0.0.7
kubectl create namespace  greet-namespace
kubectl apply -f .\greeting-service-k8.yml
kubectl get all -n greet-namespace
minikube service greet-service --url -n greet-namespace
