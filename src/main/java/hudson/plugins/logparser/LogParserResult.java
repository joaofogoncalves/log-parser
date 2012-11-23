package hudson.plugins.logparser;

import java.io.*;

public class LogParserResult  {

	
	private int totalErrors 		= 0;
	private int totalErrors_Gen 	= 0;
	private int totalErrors_Build 	= 0;
	private int totaltotalErrors    = 0;	
	private int totalWarnings 		= 0;
	private int totalInfos 			= 0;
	private int totalOks 			= 0;
	
	private String htmlLogFile;
	private String errorLinksFile;
	private String error_genLinksFile;
	private String error_buildLinksFile;
	private String warningLinksFile;
	private String infoLinksFile;
	private String okLinksFile;
	
	private String parsedLogURL;
	private String htmlLogPath;
	
	private String failedToParseError;
	private String badParsingRulesError;

	public String getBadParsingRulesError() {
		return badParsingRulesError;
	}

	public String getBadParsingRulesErrorDisplay() {
		return badParsingRulesError.replaceAll("\n", "<br/>");
	}

	public void setBadParsingRulesError(final String badParsingRulesError) {
		this.badParsingRulesError = badParsingRulesError;
	}

	public String getFailedToParseError() {
		return failedToParseError;
	}

	public void setFailedToParseError(final String failedToParseError) {
		this.failedToParseError = failedToParseError;
	}

	public int getTotalErrors() {
		return totalErrors;
	}

	public int getTotalErrors_Gen() {
		return totalErrors_Gen;
	}

	public int getTotalErrors_Build() {
		return totalErrors_Build;
	}

	public int getTotalTotalErrors() {
		return totaltotalErrors;
	}
	
	public int getTotalWarnings() {
		return totalWarnings;
	}
	
	public int getTotalInfos() {
		return totalInfos;
	}

	public int getTotalOks() {
		return totalInfos;
	}	
	
	public String getHtmlLogFile() {
		return htmlLogFile;
	}

	public String getHtmlLogPath() {
		return htmlLogPath;
	}

	public String getErrorLinksFile() {
		return errorLinksFile;
	}
	
	public String getError_GenLinksFile() {
		return errorLinksFile;
	}	

	public String getError_BuildLinksFile() {
		return errorLinksFile;
	}
	
	public String getWarningLinksFile() {
		return warningLinksFile;
	}

	public String getInfoLinksFile() {
		return infoLinksFile;
	}

	public String getOkLinksFile() {
		return infoLinksFile;
	}
	
	public String getParsedLogURL() {
		return parsedLogURL;
	}
	
    public Reader getReader(final String filePath) throws IOException {
    	final File logFile = new File(filePath);
    	if (logFile.exists() ) {
    		return new FileReader(logFile);
    	} 
    	return null;
    }
    
    public Reader getLogReader() throws IOException {
    	return getReader(getHtmlLogFile());
    }

    public Reader getErrorLinksReader() throws IOException {
    	return getReader(getErrorLinksFile());
    }

    public Reader getError_GenLinksReader() throws IOException {
    	return getReader(getError_GenLinksFile());
    }

    public Reader getError_BuildLinksReader() throws IOException {
    	return getReader(getError_BuildLinksFile());
    }	
	
    public Reader getWarningLinksReader() throws IOException {
    	return getReader(getWarningLinksFile());
    }

    public Reader getInfoLinksReader() throws IOException {
    	return getReader(getInfoLinksFile());
    }
    
    public Reader getOkLinksReader() throws IOException {
    	return getReader(getOkLinksFile());
    } 
 
	public void setHtmlLogFile(final String file) {
		this.htmlLogFile= file;
	}

	public void setHtmlLogPath(final String dir) {
		this.htmlLogPath= dir;
	}

	public void setErrorLinksFile(final String file) {
		this.errorLinksFile = file;
	}

	public void setError_GenLinksFile(final String file) {
		this.error_genLinksFile = file;
	}	

	public void setError_BuildLinksFile(final String file) {
		this.error_buildLinksFile = file;
	}	
	public void setWarningLinksFile(final String file) {
		this.warningLinksFile = file;
	}

	public void setInfoLinksFile(final String file) {
		this.infoLinksFile = file;
	}

	public void setOkLinksFile(final String file) {
		this.okLinksFile = file;
	}
	
	public void setTotalErrors(final int totalErrors) {
		this.totalErrors = totalErrors;
	}

	public void setTotalErrors_Gen(final int totalErrors) {
		this.totalErrors_Gen = totalErrors;
	}	

	public void setTotalErrors_Build(final int totalErrors) {
		this.totalErrors_Build = totalErrors;
	}	

	public void setTotalTotalErrors(final int totalErrors) {
		this.totaltotalErrors = totalErrors;
	}
	
	public void setTotalWarnings(final int totalWarnings) {
		this.totalWarnings = totalWarnings;
	}

	public void setTotalInfos(final int totalInfos) {
		this.totalInfos = totalInfos;
	}

	public void setTotalOks(final int totalInfos) {
		this.totalOks = totalInfos;
	}	
	
	public void setParsedLogURL(final String parsedLogURL) {
		this.parsedLogURL = parsedLogURL;
	}

	public File getHtmlLogFileToRead()  {
		return new File(this.htmlLogFile); 
	}

	public String getHtmlContent()  {
		final StringBuffer result = new StringBuffer("");
		String line = "";            
		try {
            File file = null;
            RandomAccessFile f = null;
	        try
	        {
	            file = this.getHtmlLogFileToRead();
	            f = new RandomAccessFile(file, "r"); 
	        	
	            while ((line = f.readLine()) != null )
	            {
	                result.append(line);
	                result.append("<br/>");
	            }
	        } finally
	        {
	            f.close(); 
	        }

		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	
}
