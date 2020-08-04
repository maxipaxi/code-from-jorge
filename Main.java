public class Main {
  void buildQueryAndProcessFunnyStuff(String dataString) { }
  void processIfFullChunk(int counter, StringBuffer dataString){
    if (counter % 20000 == 0) {
      // Process 20K chunk
      buildQueryAndProcessFunnyStuff( dataString.toString() );

      dataString = new StringBuffer();
      counter = 0; // Reset the Counter
    }
  }
  void processByChunks(String[] paramArray) {
    StringBuffer dataString = new StringBuffer();
    int counter = 0;
    for (String param : paramArray) {
        dataString.append( param ).append(",");
        counter++;
        processIfFullChunk(counter, dataString);
    }
  
    /*
    * WARNING: Code duplication
    * 
    * For the remaining beyond %20K
    */
    if (dataString!= null && dataString.length() > 0) {
        buildQueryAndProcessFunnyStuff( dataString.toString() );
    }
  }
  public static void main(String[] args){

  }
}