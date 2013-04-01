package com.common.page;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

@SuppressWarnings("unchecked")
public class Page<T> implements List {

    public static final Page EMPTY_PAGE;
    private List list;
    private int start;
    private int count;
    private boolean hasNextPage;
    private int total;

    // Constructors
    public Page(List pageList, int start, int count) {
      int end=0;
      this.total=pageList.size();
      if((start+count)<total){
        this.hasNextPage=true;
        end=start+count;
      }else{
        this.hasNextPage=false;
        end=total;
      }
      this.list = pageList.subList(start,end);
      this.start = start;
      this.count = count;
    }

    // Constructors Õë¶ÔSQL·ÖÒ³
    public Page(List list, int start, int count,int total) {
      int end=0;
      this.total=total;
      if((start+count)<total){
        this.hasNextPage=true;
        end=start+count;
      }else{
        this.hasNextPage=false;
        end=total;
      }
      this.list = list;
      this.start = start;
      this.count = count;

    }


    public List getSubList(List list, int subfrom, int subto) {
      return (List) list.subList(subfrom, subto);
    }

    public int getCurrentPage() {
      int currentPage = 1;
      if (total != 0 && (this.start+1) != 0)
        currentPage = ((this.start+1) - 1) / count + 1;
      return currentPage;
    }

    public int getTotalPage() {
      int last = 1;
      if (total != 0)
        if (total % count == 0)
          last = total / count;
        else
          last = total / count + 1;
      return last;
    }

    public int getStartOfNextPage() {
      return start + list.size();
    }

    public int getStartOfPreviousPage() {
      return Math.max(this.start - count, 0);
    }

    public int getFirstPage() {
      return 0;
    }

    public int getLastPage() {
      int last = 1;
      if (total > count)
        if (total % count == 0)
          last = (total - count) ;//+ 1;
        else
          last = (total / count) * count ;//+ 1;
      return last;
    }

    public List getList() {
      return list;
    }
    
    public int getStart() {
      if (start > 0)
        return start;
      else
        return 0;
    }

    public boolean getHasNextPage() {
      return hasNextPage;
    }

    public boolean getHasPreviousPage() {
      return start > 0;
    }

    public int getSize() {
      return list.size();
    }

    public int getCount() {
      return count;
    }

    public int getTotal() {
      return total;
    }

    static {
      EMPTY_PAGE = new Page(new Vector(Collections.EMPTY_LIST), 0, 0);
    }

    /**
     * hashCode
     *
     * @return int
     */
    public int hashCode() {
      return 0;
    }

    /**
     * size
     *
     * @return int
     */
    public int size() {
      return getList().size();
    }

    /**
     * clear
     */
    public void clear() {
    }

    /**
     * isEmpty
     *
     * @return boolean
     */
    public boolean isEmpty() {
      return false;
    }

    /**
     * toArray
     *
     * @return Object[]
     */
    public Object[] toArray() {
      return null;
    }

    /**
     * add
     *
     * @param o Object
     * @return boolean
     */
    public boolean add(Object o) {
      return false;
    }

    /**
     * contains
     *
     * @param o Object
     * @return boolean
     */
    public boolean contains(Object o) {
      return false;
    }

    /**
     * equals
     *
     * @param o Object
     * @return boolean
     */
    public boolean equals(Object o) {
      return false;
    }

    /**
     * remove
     *
     * @param o Object
     * @return boolean
     */
    public boolean remove(Object o) {
      return false;
    }

    /**
     * addAll
     *
     * @param c Collection
     * @return boolean
     */
    public boolean addAll(Collection c) {
      return false;
    }

    /**
     * containsAll
     *
     * @param c Collection
     * @return boolean
     */
    public boolean containsAll(Collection c) {
      return false;
    }

    /**
     * removeAll
     *
     * @param c Collection
     * @return boolean
     */
    public boolean removeAll(Collection c) {
      return false;
    }

    /**
     * retainAll
     *
     * @param c Collection
     * @return boolean
     */
    public boolean retainAll(Collection c) {
      return false;
    }

    /**
     * iterator
     *
     * @return Iterator
     */
    public Iterator iterator() {
      return getList().iterator();
    }

    /**
     * toArray
     *
     * @param a Object[]
     * @return Object[]
     */
    public Object[] toArray(Object[] a) {
      return null;
    }

    /**
     * get
     *
     * @param index int
     * @return Object
     */
    public Object get(int index) {
      return "";
    }

    /**
     * remove
     *
     * @param index int
     * @return Object
     */
    public Object remove(int index) {
      return "";
    }

    /**
     * add
     *
     * @param index int
     * @param element Object
     */
    public void add(int index, Object element) {
    }

    /**
     * indexOf
     *
     * @param o Object
     * @return int
     */
    public int indexOf(Object o) {
      return 0;
    }

    /**
     * lastIndexOf
     *
     * @param o Object
     * @return int
     */
    public int lastIndexOf(Object o) {
      return 0;
    }

    /**
     * addAll
     *
     * @param index int
     * @param c Collection
     * @return boolean
     */
    public boolean addAll(int index, Collection c) {
      return false;
    }

    /**
     * subList
     *
     * @param fromIndex int
     * @param toIndex int
     * @return List
     */
    public List subList(int fromIndex, int toIndex) {
      return null;
    }

    /**
     * listIterator
     *
     * @return ListIterator
     */
    public ListIterator listIterator() {
      return null;
    }

    /**
     * listIterator
     *
     * @param index int
     * @return ListIterator
     */
    public ListIterator listIterator(int index) {
      return null;
    }

    /**
     * set
     *
     * @param index int
     * @param element Object
     * @return Object
     */
    public Object set(int index, Object element) {
      return "";
    }

  }
