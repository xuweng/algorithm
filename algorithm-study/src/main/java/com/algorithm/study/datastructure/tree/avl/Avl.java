package com.algorithm.study.datastructure.tree.avl;

import com.algorithm.study.datastructure.tree.bst.BinaryNode;

public class Avl<T extends Comparable> {
    private AVLNode<T> root;

    /**
     * 左左单旋转(LL旋转) w变为x的根结点, x变为w的右子树
     *
     * @param x
     * @return
     */
    private AVLNode<T> rotateLeftLeft(AVLNode<T> x) {
        //把w结点旋转为根结点
        AVLNode<T> w = x.left;
        //同时w的右子树变为x的左子树
        x.left = w.right;
        //x变为w的右子树
        w.right = x;
        //重新计算x/w的高度
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        w.height = Math.max(height(w.left), x.height) + 1;
        return w;//返回新的根结点
    }

    /**
     * 右右单旋转(RR旋转) x变为w的根结点, w变为x的左子树
     *
     * @return
     */
    private AVLNode<T> rotateRightRight(AVLNode<T> w) {
        AVLNode<T> x = w.right;

        w.right = x.left;
        x.left = w;

        //重新计算x/w的高度
        w.height = Math.max(height(w.left), height(w.right)) + 1;
        x.height = Math.max(height(x.left), w.height) + 1;

        //返回新的根结点
        return x;
    }

    /**
     * 左右旋转(LR旋转) x(根) w y 结点 把y变成根结点
     *
     * @return
     */
    private AVLNode rotateLeftRight(AVLNode x) {
        //w先进行RR旋转
        x.left = rotateRightRight(x.left);
        //再进行x的LL旋转
        return rotateLeftLeft(x);
    }

    /**
     * 右左旋转(RL旋转)
     *
     * @param x
     * @return
     */
    private AVLNode<T> rotateRightLeft(AVLNode<T> x) {
        //先进行LL旋转
        x.right = rotateLeftLeft(x.right);
        //再进行RR旋转
        return rotateRightRight(x);
    }

    /**
     * 插入方法
     *
     * @param data
     */
    public void insert(T data) {
        if (data == null) {
            throw new RuntimeException("data can\'t not be null ");
        }
        this.root = insert(data, root);
    }

    private AVLNode<T> insert(T data, AVLNode<T> p) {
        //说明已没有孩子结点,可以创建新结点插入了.
        if (p == null) {
            p = new AVLNode<T>(data);
        } else if (data.compareTo(p.data) < 0) {//向左子树寻找插入位置
            p.left = insert(data, p.left);

            //插入后计算子树的高度,等于2则需要重新恢复平衡,由于是左边插入,左子树的高度肯定大于等于右子树的高度
            if (height(p.left) - height(p.right) == 2) {
                //判断data是插入点的左孩子还是右孩子
                if (data.compareTo(p.left.data) < 0) {
                    //进行LL旋转
                    p = rotateLeftLeft(p);
                } else {
                    //进行左右旋转
                    p = rotateLeftRight(p);
                }
            }
        } else if (data.compareTo(p.data) > 0) {//向右子树寻找插入位置
            p.right = insert(data, p.right);

            if (height(p.right) - height(p.left) == 2) {
                if (data.compareTo(p.right.data) < 0) {
                    //进行右左旋转
                    p = rotateRightLeft(p);
                } else {
                    p = rotateRightRight(p);
                }
            }
        } else {
            ;//if exist do nothing
        }
        //重新计算各个结点的高度
        p.height = Math.max(height(p.left), height(p.right)) + 1;

        return p;//返回根结点
    }

    /**
     * 删除方法
     *
     * @param data
     */
    public void remove(T data) {
        if (data == null) {
            throw new RuntimeException("data can\'t not be null ");
        }
        this.root = remove(data, root);
    }

    /**
     * 删除操作
     *
     * @param data
     * @param p
     * @return
     */
    private AVLNode<T> remove(T data, AVLNode<T> p) {
        if (p == null) {
            return null;
        }

        int result = data.compareTo(p.data);

        //从左子树查找需要删除的元素
        if (result < 0) {
            p.left = remove(data, p.left);

            //检测是否平衡
            if (height(p.right) - height(p.left) == 2) {
                AVLNode<T> currentNode = p.right;
                //判断需要那种旋转
                if (height(currentNode.left) > height(currentNode.right)) {
                    //LL
                    p = rotateLeftLeft(p);
                } else {
                    //LR
                    p = rotateLeftRight(p);
                }
            }

        }
        //从右子树查找需要删除的元素
        else if (result > 0) {
            p.right = remove(data, p.right);
            //检测是否平衡
            if (height(p.left) - height(p.right) == 2) {
                AVLNode<T> currentNode = p.left;
                //判断需要那种旋转
                if (height(currentNode.right) > height(currentNode.left)) {
                    //RR
                    p = rotateRightRight(p);
                } else {
                    //RL
                    p = rotateRightLeft(p);
                }
            }
        }
        //已找到需要删除的元素,并且要删除的结点拥有两个子节点
        else if (p.right != null && p.left != null) {

            //寻找替换结点
            p.data = findMin(p.right).data;

            //移除用于替换的结点
            p.right = remove(p.data, p.right);
        } else {
            //只有一个孩子结点或者只是叶子结点的情况
            p = (p.left != null) ? p.left : p.right;
        }

        //更新高度值
        if (p != null) {
            p.height = Math.max(height(p.left), height(p.right)) + 1;
        }
        return p;
    }

    private BinaryNode<T> findMin(AVLNode<T> right) {
        return null;
    }


    /**
     * 递归实现
     *
     * @param subtree
     * @return
     */
    private int height(AVLNode subtree) {
        if (subtree == null) {
            return 0;
        } else {
            int l = height(subtree.left);
            int r = height(subtree.right);
            return (l > r) ? (l + 1) : (r + 1);//返回并加上当前层
        }
    }

}
