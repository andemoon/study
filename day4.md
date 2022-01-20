# day4学习笔记
---
### 今日总结：线代学一天，


---
### 目录
1. 力扣题
2. 数学学习
3. python题
4. knn算法
---

#### 力扣题
写完了昨天的第二题，储水池抽样算法算是了解了。

```java
class Solution {
    ListNode head;
    Random random;//随机数构造

    public Solution(ListNode head) 
    {
    this.head=head;
    random = new Random();
    }
    
    public int getRandom() {
         int i = 1, ans = 0;
        ListNode node = head;
        while (node != null) {
            if (random.nextInt(i) == 0) {//只要保证每次概论都是1/n就行
                ans = node.val;
            }
            node = node.next;
            i++;
        }
        return ans;
    }
}

```


---

#### 数学学习
一杯可乐，一包薯片，线代学一天。

第一题
![第一题](https://andemoon.oss-cn-shenzhen.aliyuncs.com/%E5%85%B6%E4%BB%96/IMG_20220120_221706.jpg)


第二题：
![第二题](https://andemoon.oss-cn-shenzhen.aliyuncs.com/%E5%85%B6%E4%BB%96/IMG_20220120_212231.jpg)

第三题t=4，应该没算错。

---

#### python题
```python
num = int(input())
d = {}
d = dict()
i = 1

while i<=num:
 d[i]=i*i
 i+=1
else:
    for i in d.keys():
         print(i)
         print(d[i])

```
---

#### knn算法

knn算法在之间大数协数资部培训时学习过一部分，尝试复现但是没整完，出了些奇奇怪怪的bug。好像是选取距离最近的n个实例这一部分有问题



