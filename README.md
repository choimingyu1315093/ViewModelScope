ViewModel에서 Job이랑 Scope 만들고 onCleared 함수 호출해서 종료하는거 옛날 방식이다

지금은 viewModelScope 사용하면 알아서 종료된다. 왜냐하면 viewModelScope는 ViewModel의 생명 주기와 똑같이 움직이기 때문이다
