""" Node is defined as
class node:
  def __init__(self, data):
      self.data = data
      self.left = None
      self.right = None
"""
lst = []
def in_Order(root):
    if(root.left != None):
        in_Order(root.left)
    lst.append(root.data)
    if(root.right != None):
        in_Order(root.right)
def check_binary_search_tree_(root):
    
    in_Order(root)
    lst1 = lst[:]
    lst1.sort()
    # print(lst)
    # print(lst1)
    x = set(lst)
    if (len(x)!=len(lst)):
        return False
    elif(lst1 == lst):
        del lst[:]
        return True
    else:
        del lst[:]
        return False
    