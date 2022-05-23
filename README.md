![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/11f12d1b-7b94-40eb-a113-23a65d0d5d23/Untitled.png)

프로젝트는 test와 test2
총 2개의 Dynamic Web Project를 생성하여 진행했습니다.
test1은 과제에 사용한 프로젝트, test2는 비교를 위해 생성만하고 따로 설정을 하지 않았습니다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b1949d7a-4503-4cbe-8aff-cadb8048a464/Untitled.png)

처음 프로젝트 생성 시 컴파일 경로를 설정 할 수 있습니다.

- **Source folders on build path** : Java 소스 폴더
- **Default output folder** : 컴파일 결과 출력 폴더

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/983fbddc-340f-4178-912f-42bde0237409/Untitled.png)

지정한 경로에 컴파일된 모습입니다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a3424e2d-9372-48fb-9163-c542f8b30833/Untitled.png)

properties → project Facets

해당 경로에서 Dynamic Web Module 버전 선택과 Java버전 선택 등을 할 수 있습니다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b20e5339-bc5b-46e6-a987-c78254c23913/Untitled.png)

properties → Deployment Assembly

해당 경로에서 WAS가 실행하는데 필요한 클래스 파일 및 설정 파일 등이 저장됩니다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e40f4bb2-6494-49de-b4fd-0ee2d48102ca/Untitled.png)

test 프로젝트에 톰캣을 추가한 후 설정한 배포 경로입니다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ceeafe9b-4dd1-4dc4-bc2e-05ad05ef3100/Untitled.png)

톰캣을 추가한 test 프로젝트는 톰캣설치경로\webapps\test 경로에 프로젝트가 생성되어있습니다.
test2 프로젝트는 톰캣을 추가하지않았기에 생성되어있지 않습니다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/3e79830d-ac51-4dbe-927d-856affafe84c/Untitled.png)

지정한 경로에 클래스파일이 배포된 모습입니다.
