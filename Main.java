public class Main {
  void buildQueryAndProcessFunnyStuff(String dataString) { }
  private class Chunk {
    private int counter; 
    private int size; 
    private StringBuffer dataString;
    Chunk(int counter, StringBuffer dataString, int size) {
      this.counter = counter;
      this.dataString = dataString; 
      this.size = size;
    }
    void processIfFull(){
      if (counter % size == 0) {
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
    Chunk chunk = new Chunk(counter, dataString, 20000);
    for (String param : paramArray) {
      chunk.addElement(param);
    }
    chunk.finalizeChunk();
  }
  public static void main(String[] args){

  }
}