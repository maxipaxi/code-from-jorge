public class Main {
  void buildQueryAndProcessFunnyStuff(String dataString) { }
  private class Chunk {
    private int counter; 
    private int size; 
    private StringBuffer dataString;
    Chunk(int size) {
      dataString = new StringBuffer();
      counter = 0;
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
    Chunk chunk = new Chunk(20000);
    for (String param : paramArray) {
      chunk.addElement(param);
    }
    chunk.finalizeChunk();
  }
  public static void main(String[] args){

  }
}