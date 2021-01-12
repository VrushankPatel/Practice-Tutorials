import java.lang.Math;
import DateTime;
import java.sql.Timestamp;
import java.security.MessageDigest;  

class BlockChain{

    int diff = 20;
    long maxNounce = Math.pow(2, 32);
    long target = Math.pow(2, (256 - diff));
    Block block = Block("Genesis");
    Block dummy = block, head = block;

    void add(Block block){
        block.previousHash = this.block.hash();
        block.blockNo = this.block.blockNo + 1;

        this.block.next = block;
        this.block = this.block.next;
    }

    void mine(Block block){
        for (int i = 0; i < this.maxNounce; i++){
            )
        }
    }
}

class Block{
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    int blockNo = 0;
    String data;
    Block next;
    String hash;
    int nounce = 0;
    String previousHash = 0x0;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
    Block(String data){
        this.data = data;
    }

    String hash(){
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(
            (self.nonce).encode('utf-8').toString() +
            (self.data).encode('utf-8').toString() +
            (self.previous_hash).encode('utf-8').toString() +
            (self.timestamp).encode('utf-8').toString() +
            (self.blockNo).encode('utf-8').toString()
        )
    }

    String toString() {
        return "Block Hash: " + (this.hash()).toString() + "\nBlockNo: " + (this.blockNo).toString() + "\nBlock Data: " + (this.data).toString() + "\nHashes: " + (this.nonce).toString() + "\n--------------"
    }


}