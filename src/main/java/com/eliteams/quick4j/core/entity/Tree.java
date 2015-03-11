package com.eliteams.quick4j.core.entity;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 15-3-6
 * Time: 下午6:06
 * To change this template use File | Settings | File Templates.
 */
public class Tree<T> {

    private T head;

    private ArrayList<Tree<T>> leafs = new ArrayList<Tree<T>>();

    private Tree<T> parent = null;

    private HashMap<T, Tree<T>> locate = new HashMap<T, Tree<T>>();

    public Tree(T head) {
        this.head = head;
        locate.put(head, this);
    }

    public void addLeaf(T root, T leaf) {
        if (locate.containsKey(root)) {
            locate.get(root).addLeaf(leaf);
        } else {
            addLeaf(root).addLeaf(leaf);
        }
    }

    public Tree<T> addLeaf(T leaf) {
        Tree<T> t = new Tree<T>(leaf);
        leafs.add(t);
        t.parent = this;
        t.locate = this.locate;
        locate.put(leaf, t);
        return t;
    }

    public Tree<T> setAsParent(T parentRoot) {
        Tree<T> t = new Tree<T>(parentRoot);
        t.leafs.add(this);
        this.parent = t;
        t.locate = this.locate;
        t.locate.put(head, this);
        t.locate.put(parentRoot, t);
        return t;
    }

    public T getHead() {
        return head;
    }

    public Tree<T> getTree(T element) {
        return locate.get(element);
    }

    public Tree<T> getParent() {
        return parent;
    }

    public Collection<T> getSuccessors(T root) {
        Collection<T> successors = new ArrayList<T>();
        Tree<T> tree = getTree(root);
        if (null != tree) {
            for (Tree<T> leaf : tree.leafs) {
                successors.add(leaf.head);
            }
        }
        return successors;
    }

    public Collection<Tree<T>> getSubTrees() {
        return leafs;
    }

    public static <T> Collection<T> getSuccessors(T of, Collection<Tree<T>> in) {
        for (Tree<T> tree : in) {
            if (tree.locate.containsKey(of)) {
                return tree.getSuccessors(of);
            }
        }
        return new ArrayList<T>();
    }

    @Override
    public String toString() {
        return printTree(0);
    }

    private static final int indent = 2;

    private String printTree(int increment) {
        String s = "";
        String inc = "";
        for (int i = 0; i < increment; ++i) {
            inc = inc + " ";
        }
        s = inc + head;
        for (Tree<T> child : leafs) {
            s += "\n" + child.printTree(increment + indent);
        }
        return s;
    }

    public static void main(String[] args){
        Tree tree = new Tree("hello");
        tree.addLeaf("A", "B");
        tree.addLeaf("A", "C");
        tree.addLeaf("C", "D");
        tree.addLeaf("E", "F");

        Gson gson = new Gson();

//        System.out.println(gson.toJson(tree));
        System.out.println(tree.printTree(2));
    }
}