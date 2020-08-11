# RESTful Web Service 개발
> <b>REST</b> = <b>RE</b>presentational <b>S</b>tate <b>T</b>ransfer<br>
> Core Concept of REST Architecture : 'Resource'

#### Resource
```
REST API는 DB 등에서 관리되는 정보에서 Client에 제공할 정보를 'Resource'의 형태로 추출.
추출된 resource는 웹에 공개되고 resource에 접근하기 위한 수단으로 REST API를 제공
```
## REST API Architecture

### Resource Oriented Architecture (ROA)
#### 1. 웹의 resource로 공개
> Client에 제공할 정보는 웹에서 resource로 공개. 즉 HTTP 프로토콜을 사용해 resource에 접근 가능

#### 2. URI를 통한 resource 식별
> 웹에 공개할 resource에는 그 resource를 고유하게 식별할 수 있는 URI를 할당해 같은 네트워크에 연결돼 있다면 어디서든 같은 resource에 접근 가능

#### 3. HTTP 메서드를 통한 resource 조작
> resource에 대한 CRUD 조작은 HTTP 메서드(GET, POST, PUT, DELETE 등)를 용도에 맞게 잘 나눠서 구현해야 함

- 자주 사용되는 HTTP 메서드와 역할
<table>
  <tr>
    <th>HTTP Method</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>GET</td>
    <td>URI에 지정된 resource를 가져옴</td>
  </tr>
  <tr>
    <td>POST</td>
    <td>resource를 생성하고 생성된 resource에 접근할 수 있는 URI를 받아옴</td>
  </tr>
  <tr>
    <td>PUT</td>
    <td>URI에 지정한 resource를 생성하거나 갱신</td>
  </tr>
  <tr>
    <td>DELETE</td>
    <td>URI에 지정한 resource를 삭제</td>
  </tr>
</table>

#### 4. 적절한 포맷 사용
> resource 포맷으로는 읽기 쉽고 데이터 구조를 잘 표현하는 JSON / XML과 같은 포맷 사용

#### 5. 적절한 HTTP 상태 코드를 사용
> HTTP 상태 코드는 서버 측의 처리 결과를 알려주기 위한 것<br>
> REST API가 응답하는 HTTP 사태 코드의 정확성 상당히 중요

- HTTP 상태 코드 분류
<table>
  <tr>
    <th>Group</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>1xx</td>
    <td>요청을 접수하고 처리를 계속하고 있음을 알리는 응답 코드</td>
  </tr>
  
  <tr>
    <td>2xx</td>
    <td>요청을 접수하고 처리가 완료됐음을 알리는 응답 코드</td>
  </tr>
  
  <tr>
    <td>3xx</td>
    <td>요청을 완료하기 위해 추가적인 처리(redirect 등)가 필요함을 알리는 응답 코드</td>
  </tr>
  
  <tr>
    <td>4xx</td>
    <td>요청에 결함이 있으므로 처리를 중단함을 알리는 응답 코드</td>
  </tr>
  
  <tr>
    <td>5xx</td>
    <td>요청에 대해 서버가 제대로 처리하지 못함을 알리는 응답 코드</td>
  </tr>
</table>

#### 6. Client와 Server 간의 무상태 통신
> Application Server가 HTTP Session 과 같은 공유 메모리를 사용하지 않고 요청 데이터만으로 resource를 조작하는 것<br>
> Stateless 통신을 구현할 때는 application의 상태(화면 등의 상태)를 Client 측의 application(DOM, Javascript variables etc)에서 관리해야 함

#### 7. 연관된 resource에 대한 링크
> resouce에는 관련된 resource나 subresource에 대한 Hypermedia 링크(URI)를 포함할 수 있음 (HATEOAS Architecture)<br>
> Client와 Server 간의 결합도 낮출 수 있는 효과

### Architecture of Framework
![rest_arch](https://user-images.githubusercontent.com/60098657/89868752-4be1a580-dbee-11ea-8279-9e45d0f8a962.png)
(from : https://terasolunaorg.github.io/guideline/5.0.1.RELEASE/en/ArchitectureInDetail/REST.html)

#### HttpMessageConverter
![messageconverter](https://user-images.githubusercontent.com/60098657/89869750-c232d780-dbef-11ea-9c69-e73646345e8f.png)
(from : https://sjh836.tistory.com/141)
