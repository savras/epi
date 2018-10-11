class MergeTwoSortedLinkedList {

    public static void main(String[] args) 
    {
        LinkedList l1 = new LinkedList(2);
        l1.next = new LinkedList(5);
        l1.next.next = new LinkedList(6);

        var l2 = new LinkedList(3);
        l2.next = new LinkedList(11);

        var merged = mergeLinkedList(l1, l2);

        var current = merged;
        while(current != null)
        {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    public static LinkedList mergeLinkedList(LinkedList l1, LinkedList l2)
    {
        var head = new LinkedList();
        var current = head;

        while(l1 != null && l2 != null)
        {
            if(l1.value > l2.value) {
                current.next = l2;
                l2 = l2.next;
            }
            else {
                current.next = l1;
                l1 = l1.next;
            }
            current = current.next;
        }

        current.next = l1 == null ? l2 : l1;

        return head.next;
    }
}

class LinkedList {
    int value;
    public LinkedList next;

    public LinkedList() { };
    public LinkedList(int value) 
    {
        this.value = value;
    }
}