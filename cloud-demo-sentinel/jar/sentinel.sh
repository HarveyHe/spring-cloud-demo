#!/bin/bash
java -Dsentinel.dashboard.auth.username=admin \
-Dsentinel.dashboard.auth.password=admin \
-Dserver.port=8084 -Dcsp.sentinel.dashboard.server=localhost:8084 \
-Dproject.name=sentinel-dashboard \
-jar sentinel-dashboard-1.6.3.jar &
