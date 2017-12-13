# Object Oriented Project

# Overview:
This project develops geographic data collection system. <br /> 
The system interpret the data and present the information with graphic tools.

# General Description
 The program is divided into three parts: <br />
**part 1:** <br /> 
The program reads csv files from the aplication **wiglewifi**,the files contains Scan of WIFI spot that were sampled.<br />
The program sort each time period and location its points by its signal, and takes the 10 most strongest.Then it create a new CSV file  which each row  represent one Scan (the wifi spots with the same time and location) with the most 10 WIFI points with its information.
 <br />
**part 2:** <br /> 
The program reads a csv file (that we write in part 1) and filter the data by time,place or id. and creat a kml file. <br />

# Links:
<a href=https://labs.micromata.de/projects/jak/kml-in-the-java-world.html>API for KML</a> <br />
<a href=https://wigle.net/>Infomation about Wigle Wifi </a> <br />
<a href=https://en.wikipedia.org/wiki/Comma-separated_values>CSV </a> <br />
<a href=https://en.wikipedia.org/wiki/Keyhole_Markup_Language>KML </a> <br />
