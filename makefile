JFLAGS = -g -cp $(BIN) -d $(BIN)
JC = javac
BIN = bin
SRC = src

PSR : $(BIN)/PSR.class
	echo "java -cp bin PSR" > PSR
	chmod 755 PSR

$(BIN)/PSR.class : $(SRC)/PSR.java
	$(JC) $(JFLAGS) $(SRC)/PSR.java

clean:
	        $(RM) $(BIN)/*.class
		rm PSR
