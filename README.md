# Kubernetes Health Check Demo

This project contains two Spring Boot applications designed to demonstrate health checks and readiness probes in a Kubernetes environment.

## Quick Test Steps

### 1. Deploy Applications

```bash
kubectl apply -f kube-hello/deployment.yaml
kubectl apply -f kube-health/deployment.yaml
```
### 2. Wait for Pods to be Ready

```bash
kubectl get pods
```

### 3. Check health
Check the first basic application that only returns "Hello World":
```bash
curl http://<NODE_IP>:31880/hello
```
Check the second application that returns a health status depending on the state of the first application:
```bash
curl http://<NODE_IP>:31881/health
```
Replace `<NODE_IP>` with the external IP of a cluster node.
