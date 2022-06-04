## 트리 순회  #1991
----
[문제 원본 링크](https://www.acmicpc.net/problem/1991)

[개인 노션 링크](https://leedongyeop.notion.site/1991-147100707b0343f9a0d9ba76ac80ca86)

이진 트리를 입력받아 순회 종류에 따라 결과를 출력하는 프로그램을 작성하시오.
- 전위 순회(preorder traversal) 
- 중위 순회(inorder traversal)
- 후위 순회(postorder traversal)

#### 입력 조건
1. 첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다. 

2. 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다. 
3. 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 
4. 자식 노드가 없는 경우에는 . 으로 표현한다.