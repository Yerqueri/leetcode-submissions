/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Node> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, new Node(employee));
        }
        for (Employee employee : employees) {
            Node node = map.get(employee.id);
            for (Integer i : employee.subordinates) {
                node.subordinates.add(map.get(i));
            }
        }
        return traverse(map.get(id));
    }

    private int traverse(Node node) {
        int val = node.employee.importance;
        for (Node nd : node.subordinates) {
            val += traverse(nd);
        }
        return val;
    }

    class Node {
        Employee employee;
        List<Node> subordinates;

        Node(Employee employee) {
            this.employee = employee;
            this.subordinates = new ArrayList<>();
        }
    }
}