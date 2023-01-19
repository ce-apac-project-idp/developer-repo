#!/bin/bash

NAMESPACE=backstage
IMAGE=demo-app-react:latest
REGISTRY=$(oc get route default-route -n openshift-image-registry --template='{{ .spec.host }}')
REGISTRY_INTERNAL="image-registry.openshift-image-registry.svc:5000"
REMOTE_IMAGE="$REGISTRY/$NAMESPACE/$IMAGE"

docker build -t "$IMAGE" -f Dockerfile .

#docker login -u kubeadmin -p $(oc whoami -t) "$REGISTRY"
docker tag "$IMAGE" "$REMOTE_IMAGE"
docker push "$REMOTE_IMAGE"

echo "Done!"
echo "Refer this image as $REGISTRY_INTERNAL/$NAMESPACE/$IMAGE"