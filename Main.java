public class Main {
  void buildQueryAndProcessFunnyStuff(String dataString) { }
  private class Chunk {
    private int counter; 
    private StringBuffer dataString;
    Chunk(int counter, StringBuffer dataString) {
      this.counter = counter;
      this.dataString = dataString; 
    }
    void processIfFull(){
      if (counter % 20000 == 0) {
        // Process 20K chunk
        buildQueryAndProcessFunnyStuff( dataString.toString() );

        dataString = new StringBuffer();
        counter = 0; // Reset the Counter
      }
    }
    void finalizeChunk(){
      /*
      * WARNING: Code duplication
      * 
      * For the remaining beyond %20K
      */
      if (dataString!= null && dataString.length() > 0) {
          buildQueryAndProcessFunnyStuff( dataString.toString() );
      }
    }
    void addElement(String element){
      dataString.append( element ).append(",");
      counter++;
      processIfFull();
    }
  }
  void processByChunks(String[] paramArray) {
    StringBuffer dataString = new StringBuffer();
    int counter = 0;
    Chunk chunk = new Chunk(counter, dataString);
    for (String param : paramArray) {
      chunk.addElement(param);
    }
    chunk.finalizeChunk();
  }
  public static void main(String[] args){

  }
}