public class Main {
  void buildQueryAndProcessFunnyStuff(String dataString) { }
  private interface StuffProcessor {
    void execute(String str);
  }
  private class StuffProcessorImpl implements StuffProcessor {
    public void execute(String str){
      buildQueryAndProcessFunnyStuff( str );
    }
  }
  private class Chunk {
    private int counter; 
    private int size; 
    private StringBuffer dataString;
    private StuffProcessor processor;
    Chunk(int size, StuffProcessor processor) {
      this.processor = processor;
      dataString = new StringBuffer();
      counter = 0;
      this.size = size;
    }
    void processIfFull(){
      if (counter % size == 0) {
        processAndReset();
      }
    }
    void processAndReset(){
      // Process 20K chunk
      processor.execute(dataString.toString());

      dataString = new StringBuffer();
      counter = 0; // Reset the Counter
    }
    void finalizeChunk(){
      if (counter > 0) {
        processAndReset();
      }
    }
    void addElement(String element){
      dataString.append( element ).append(",");
      counter++;
      processIfFull();
    }
  }
  void processByChunks(String[] paramArray) {
    Chunk chunk = new Chunk(20000, new StuffProcessorImpl());
    for (String param : paramArray) {
      chunk.addElement(param);
    }
    chunk.finalizeChunk();
  }
  public static void main(String[] args){

  }
}