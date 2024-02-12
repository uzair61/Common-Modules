APP_FILE=${1}

echo Starting ${APP_FILE}

runMicroservice(){
java  -jar /home/${APP_FILE}
}

_main(){
	runMicroservice
}

_main