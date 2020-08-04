public class Main {
  void buildQueryAndProcessFunnyStuff(String dataString) { }
  private class Chunk {
    void processIfFull(int counter, StringBuffer dataString){
      if (counter % 20000 == 0) {
        // Process 20K chunk
        buildQueryAndProcessFunnyStuff( dataString.toString() );

        dataString = new StringBuffer();
        counter = 0; // Reset the Counter
      }
    }
    void finalizeChunk(StringBuffer dataString){
      /*
      * WARNING: Code duplication
      * 
      * For the remaining beyond %20K
      */
      if (dataString!= null && dataString.length() > 0) {
          buildQueryAndProcessFunnyStuff( dataString.toString() );
      }
    }
    void addElement(String element, int counter, StringBuffer dataString){
      dataString.append( element ).append(",");
      counter++;
      processIfFull(counter, dataString);
    }
  }
  void processByChunks(String[] paramArray) {
    StringBuffer dataString = new StringBuffer();
    int counter = 0;
    Chunk chunk = new Chunk();
    for (String param : paramArray) {
      chunk.addElement(param, counter, dataString);
    }
    chunk.finalizeChunk(dataString);
  }
  public static void main(String[] args){

  }
}