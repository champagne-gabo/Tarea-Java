No Java's Sky 

A terminal-based space exploration game built in Java, inspired by No Man's Sky.

Explore different planets, collect resources, trade with inhabitants, manage your ship and exosuit, and travel through the galaxy with one goal: reach the galactic center.

Features

-Multiple planet types with different characteristics

-Resource extraction

-Inventory system

-Ship fuel and propulsion management

-xosuit energy management

-rading with planetary inhabitants

-Galactic exploration and travel

-Emergency system with limited rescues

-Interactive terminal-based gameplay

Built with

Java

Project structure

NoJavaSky.java       main game loop
Jugador.java         player state and inventory
Nave.java            ship and propulsion system
MapaGalactico.java   galaxy navigation and planet generation
Planeta.java         base planet class
Helado.java          frozen planet
Oceanico.java        ocean planet
Volcanico.java       volcanic planet
Radiactivo.java      radioactive planet
CentroGalactico.java galactic center
Tradeo.java          trading system
GameUtils.java       terminal and game utilities

Running the game

Clone the repository:

git clone https://github.com/gabalero8/no-java-sky.git
cd no-java-sky

Compile:

javac *.java

Run:

java NoJavaSky

Background

Originally developed as a university assignment for INF-253.

I kept the project because it became a much more complete game than the assignment name suggested :)
