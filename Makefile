JAVAC = javac
MAIN_CLASS = NoJavaSky


ifeq ($(OS),Windows_NT)
    RM = del /f
else
    RM = rm -f
endif

all: 
	$(JAVAC) *.java

run: all
	java $(MAIN_CLASS)

clean:
	$(RM) *.class
