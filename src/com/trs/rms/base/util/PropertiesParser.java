package com.trs.rms.base.util;
import java.io.BufferedReader;
import java.io.IOException;


public interface PropertiesParser {

	void parse(BufferedReader source,PropertiesHandler handler) throws IOException;
}
