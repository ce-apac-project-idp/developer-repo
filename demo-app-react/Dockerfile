FROM registry.redhat.io/rhel8/nodejs-18

CMD ['/bin/bash', '-c', 'while true; do sleep 1; done;']

# WORKDIR /opt/app
# COPY . .

# USER 0

# RUN chgrp -R 0 /opt/app && \
#     chmod -R g=u /opt/app

# USER 1001
# RUN fix-permissions ./

# RUN npm install -g serve
# RUN npm install
# RUN npm run build

# CMD ["serve", "-s", "build", "-l", "3000"]
