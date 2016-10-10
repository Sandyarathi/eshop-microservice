DIRECTORY=eshop-ui/target
if [ ! -d "$DIRECTORY" ]; then
	mkdir $DIRECTORY
fi

W1=eshop-ui.war
SRC=eshop-ui
SRC_ROOT=eshop-ui

# Clean last war build
if [ -e ${SRC_ROOT}/target/${W1} ]; then
    echo "Removing old war ${W1}"
    rm -rf ${SRC_ROOT}/${W1}
fi

# Build war
if [ -d ${SRC} ]; then
    echo "Found source at ${SRC}"
    cd ${SRC}
    jar -cvf target/${W1} *
fi

# Show war details
ls -la ../target/${W1}
echo SUCCESS!
