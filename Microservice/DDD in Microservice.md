# Microservice에서의 DDD
## DDD란?
* DDD는 핵심 도메인으로 경계지어진 진화하는 복잡한 모델을 다루는 소프트웨어 개발 방안입니다.
* DDD에서 모델이 적용되는 컨텍스트를 정의합니다. 
* 팀 조직, 어플리케이션의 특정 부분에서의 사용, 코드 베이스와 데이터베이스 스키마 같은 측면에서 명시적인 경계를 설정하고 이 경계 안에서 모델을 엄격히 일관되게 유지합니다.

## 유비쿼터스 언어
* DDD에서는 개발자와 사용간에 공통적이고 엄격한 언어를 구축해야 합니다.
* 이 언어는 도메인 모델에 기초해야 하며, 도메인 전문가와 공통적이고 유동적인 대화를 하는데 도움이 되며, 테스트가 가까워지면 필수적이라는 것을 알 수 있습니다.
* 도메인 모델뿐만 아니라 도메인 로직, 심지어 아키텍처에서도 유비쿼터스 언어가 사용돼야 합니다.

## 경계된 컨텍스트
* 도메인 모델이 커지면 통합 도메인 모델을 만드는 것이 복잡해집니다. 때로는 하나의 개념에 서로 다른 두 가지 표현이 존재하는 상황을 직면하게 됩니다.
* 각 모델마다의 고유한 이름을 가질 수 있지만, 각각 컨텍스트에 따라 완전히 다른 모델과 로직을 가질 수도 있습니다.
* DDD에서는 모델을 경게된 컨텍스트로 구분합니다. 외부와 분리해서 경계 안의 지식을 일관되게 유지시켜 주기 때문에 특정 도메인 모델을 위한 유비쿼터스 언어를 가질 수 있습니다.

## 컨텍스트 매핑
* 여러 경게된 컨텍스트를 위해 설계된 대규모 어플리케이션에서는 전체에 대한 시각을 놓칠 수 있습니다.
* 컨텍스트 맵은 시스템의 전체 뷰로서 경계된 컨텍스트 간에 커뮤니케이션 방식을 보여줍니다.

## 마이크로서비스에서 DDD 사용하기
* 경계된 컨텍스트: 하나 이상의 경계된 컨텍스트를 포함하는 마이크로서비스를 마들지 말아야 합니다.
* 유비쿼터스 언어: 마이크로서비스가 사용하는 언어가 유비쿼터스 언어임을 보장해야 하므로, 노출된 오퍼레이션과 인터페이스는 컨텍스트 도메인 언어로 표현됩니다.
* 컨텍스트 모델: 마이크로서비스가 제공하는 인터페이스에 노출되지 않은 엔티티라 하더라도, 마이크로서비스가 사용하는 모델은 경계된 컨텍스트 내에서 정의돼야 하며 유비쿼터스 언어를 사용해야 합니다.
* 컨텍스트 매핑: 마지막으로 마이크로서비스의 의존성과 결합을 이해하기 위해 전체 시스템의 컨텍스트 매핑을 검토해야 합니다.

* 위의 사항들을 검토해보면 이전에 마이크로서비스의 주요 원칙들을 이행하고 있음을 알 수 있습니다.
* DDD를 따르는 마이크로 서비스 아키텍처는 팀 구성원이 이해할 수 있는 클린 아키텍처를 제공합니다.