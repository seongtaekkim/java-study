
/**
 *  use try-with-resources rather than try-finally
 */
public class Item09 {
    public static void main( String[] args ) {
        
    }
  
  
  // try-finally
  static String firstLineOfFile(String path) throws IOException {
   BufferedReader br = new BufferedReader(new FileReader(path));
    
    try {
      return br.readLine();
    } finally {
     br.close(); 
    }
  }
  
  // try-finally(2)
  static void copy(String src, String dst) throws IOException {
   InputStream in = new FileInputStream(src);
    try {
      OutputStream out = new FileOutputStream(dst);
      try {
        byte[] buf = new byte[BUFFER_SIZE];
        int n;
        while ((n=in.read(buf))>=0)
          out.write(buf,0,n);
      } finally {
        out.close();
      }
    } finally {
     in.close(); 
    }
  }
  
  
  // try-with-resources
  static String firstLineOfFile(String path) throws IOException {
   try(BufferedReader br = new BufferedReader(new FileReader(path))) {
     return br.readLine();
   }
  }
  // try-with-resources(2)
  static void copy(String src, String dsp) throws IOException {
   try(InputStream in = new FileInputStream(src);
       OutputStream out = new FileOutputStream(dsp) {
         byte[] buf = new byte[BUFFER_SIZE];
         int n;
         while((n=in.read(buf)) >= 0) 
           out.write(buf,0,n);
       }
  }
  
  // try-with-resources with catch
  static String firstLineOfFile(String path, String defaultVal) {
   try(BufferedReader br = new BufferedReader(new FileReader(path))) {
        return br.leadLine);
   } catch (IOException e) {
     return defaultVal;
   }
  }
  
}

