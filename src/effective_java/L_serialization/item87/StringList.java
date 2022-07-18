package effective_java.L_serialization.item87;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// StringList with a reasonable custom serialized form
public final class StringList implements Serializable {

    private static class Node {
        String data;
        Node nextNode;

        public Node(String data) {
            this.data = data;
        }
    }

    private transient int nofNodes;
    private transient Node head;

    public StringList() {
        this.nofNodes = 0;
        this.head=null;
    }

    public final void add(String s) {
        insertNode(s);
        increaseNofNodes();
    }

    private void increaseNofNodes() {
        nofNodes++;
    }

    private void insertNode(String s) {
        Node newNode = new Node(s);
        if(head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while(currentNode.nextNode != null) {
                currentNode= currentNode.nextNode;
            }
            currentNode.nextNode = newNode;
        }
    }

    public List<String> getData() {
        List<String> stringList=new ArrayList<>();
        for (Node e = head; e != null; e = e.nextNode) {
            stringList.add(e.data);
        }
        return stringList;

    }

    /**
     * Serialize this {@code StringList} instance.
     *
     * @serialData The size of the list (the number of strings * it contains) is emitted ({@code int}), followed by all of * its elements (each a {@code String}), in the proper
     * sequence.
     */
    private void writeObject(ObjectOutputStream s)
            throws IOException {
        s.defaultWriteObject();
        s.writeInt(nofNodes);
        writeNodes(s);
    }

    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();
        readNodes(s, numElements);
    }

    private void writeNodes(ObjectOutputStream s) throws IOException {
        for (Node e = head; e != null; e = e.nextNode)
            s.writeObject(e.data);
    }

    private void readNodes(ObjectInputStream s, int numElements) throws IOException, ClassNotFoundException {
        for (int i = 0; i < numElements; i++)
            add((String) s.readObject());
    }
    // Remainder omitted



}
