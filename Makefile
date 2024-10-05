JAVAC = javac

MAIN_CLASS = Main

all: 
	$(JAVAC) *.java

run: all
	java $(MAIN_CLASS)

clean:
	del /f *.class