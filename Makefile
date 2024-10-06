JAVAC = javac


MAIN_CLASS = NoJavaSky

all: 
	$(JAVAC) *.java

run: all
	java $(MAIN_CLASS)

clean:
	del /f *.class
