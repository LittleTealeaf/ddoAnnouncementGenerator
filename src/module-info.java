module ddoAnnouncementGenerator {

	exports application;
	exports classes;
	exports ui to javafx.graphics;
	
	opens classes to com.google.gson;

	requires javafx.base;
	requires transitive javafx.graphics;
	requires transitive javafx.controls;
	requires transitive com.google.gson;
	requires net.harawata.appdirs;
	requires java.datatransfer;
	requires java.desktop;
	requires java.xml;
}