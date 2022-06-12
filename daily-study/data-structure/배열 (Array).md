# 배열 (Array)

## 배열?

- 배열은 인덱스와 인덱스에 대응하는 데이터들로 이루어진 연속적인 자료구조

```bash
// 일반적인 정수형 변수를 사용
int a = 1;
int b = 2;
int c = 3;
int d = 4;

// 배열을 사용
int[] arrays = new int[3];

arrays[0] = 1;
arrays[1] = 2;
arrays[2] = 3;
arrays[3] = 4;

// 인덱스에 저장된 데이터를 가져옴
```

## Java 에서 배열

- 배열의 크기

```bash
int[] arrays = new int[3];

System.out.print("배열의 사이즈 "+arrays.length);
```

- 배열 출력

```bash
for(int i : arrays){
       System.out.print("배열 데이터"+i);

}
```

- 다차원 배열

```bash
int[][] arrays = new int[3][3];
int[][] arrays = {{2, 5, 3},{4, 4, 1}, {1, 7, 3}};
```