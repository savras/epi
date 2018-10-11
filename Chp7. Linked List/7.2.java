class ReverseLinkedList {
    public static void main(String[] args) 
    {
        var head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(4);
        head.next.next.next.next = new LinkedList(5);

        var resultNode = reverseLinkedList(head);

        var current = resultNode;
        while(current != null)
        {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    public static LinkedList reverseLinkedList(LinkedList head) 
    {
        if(head == null) { return head; }
        if(head.next == null) { return head; }

        LinkedList prev = null;
        LinkedList current = head;
        LinkedList forw = current.next;
        current.next = prev;

        while(forw != null) {
            prev = current;
            current = forw;
            forw = current.next;
            current.next = prev;
        }

        return current;
    }
}

class LinkedList 
{
    public int value;
    public LinkedList next;

    public LinkedList(int value) 
    {
        this.value = value;
    }
}
