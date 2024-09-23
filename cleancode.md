# Clean Code

본 교재에서는 보다 깔끔하고, 정돈된 형태로 코드를 짜는 방식에 대해 체계적으로 정리하고 있다.
방대한 양의 코드를 많은 사람들과 함께 작성하고, 수정하고, 업데이트해 나가는 경우가 대다수인 오늘날의 소프트웨어 개발자들에게 
이러한 clean code 규칙을 준수하는 것은 자신과 타인 모두에게 도움이 되는 행동이자 사실상 필수적으로 요구되는 역량이라고 생각한다.
나 또한 다른 사람들의 코드를 보고 직관적인 해석을 어려워하거나, 때때로는 내가 과거에 작성했던 코드를 활용하고자 할 때조차 난잡하게 
작성된 코드로 인해 많은 시간을 소모하게 되는 경우가 있었다. 그런 경험이 있기에 책에서 이야기하는 내용에 더욱 공감이 되고, 규칙을 습득하는 데 중요성을 느낀다.

책에서 다루고 있는 내용 일부는 이전에 수강했던 프로그래밍스튜디오 과목에서 학습한 코딩스타일과 동일했기에 다소 이해하기 편했다.
실제로 해당 과목의 과제로 Clean Code Criteria에 맞추어 기존에 작성했던 코드의 문제점을 찾고 refactoring을 수행하는 경험을 통해 이를 따르는 것이
코드 가독성을 훨씬 높이고 전반적인 코드 구조의 설계나 활용에도 도움을 준다는 사실을 체감했다. 무엇보다 정말 엄청난 수준의 시간 절약을 가져다 주기에, 
책을 읽으며 각 장에서 강조했던 규칙이나 주요하게 나왔던 설명을, 내가 부족한 부분을 중심으로 간단히 정리해두어 추후에도 활용할 수 있도록 하려고 한다.

---

### Ch2: Meaningful Names 

코드에 사용할 변수/함수 이름을 '잘' 짓는 것은 매우 중요하다. 기본적으로 이름을 읽는 것만으로 해당 변수/함수가 어떤 역할을 하는지 직관적으로 파악할 
수 있어야 하며, 중복되는 이름 선정 같이 독자에게 혼란을 주는 행동은 피하고 코드 전체에서 일관된 이름짓기 방식을 유지해야 한다.

- [ ] Are the names of classes, methods, and variables meaningful?

- [ ] Do they reveal the intention of the code?

- [ ] Are they pronounceable, searchable, and unambiguous?

```
• Use Intention-Revealing Names
• Avoid Disinformation
• Make Meaningful Distinctions
• Use Pronounceable Names
• Use Searchable Names
• Avoid Encodings
• Avoid Mental Mapping
• Pick One Word per Concept
• Use Solution Domain Names generally
• Use Problem Domain Names for problem domain related concepts
• Add Meaningful Context
```

보통 meaningful name을 짓고자 하면 이름이 길어지는 경우가 많아 고민이 되는데, 두려워할 필요 없다. 이름에 불필요한 맥락이 포함된게
아니라면, 짧고 함축적인 이름보다 길더라도 의미가 담긴 이름의 가독성이 더 높다.

좋은 이름을 선택하려면 설명 능력이 뛰어나야 하고 문화적인 배경이 같아야 한다. 코딩 경험을 꾸준히 쌓으면서 여러 clean code들을 접하게 된다면 
자신만의 좋은 이름짓기 기준을 세울 수 있을 것이다.

---

### Ch3: Functions

프로그램의 가장 기본적인 단위는 함수로, 이를 잘 구성해야만 생각지 못한 오류를 방지하고 프로그램 전체를 이해하기 쉽다.
복잡하게 여러 작업을 수행하며 길게 늘어진 함수는 최악이다. "기본 단위"에 걸맞게, 더 이상 나눌 수 없을 때까지 수행하는 작업을 나누어 함수를 할당하자.

- [ ] Are the functions short and focused?

- [ ] Do they do one thing and have a small number of arguments?

- [ ] Do they have a low number of side effects?

```
• Small
• Do One thing
• One Level of Abstraction per Function
• Avoid using Switch statements
• Use Descriptive Names
• Fewer function arguments are better (Try not to have more than 2)
• Have No Side Effects
• Command Query Separation
• Prefer Exceptions to Returning Error Codes
• Don't Repeat Yourself
• Structured Programming
```

함수는 한 가지만을 해야 하며, 함수에서 단순히 다른 표현이 아니라 의미 있는 이름으로 다른 함수를 추출할 수 있는가로 그 함수가 여러 작업을 하는지 확인 가능하다.
단위 역할별로 함수를 나누고 각각에 서술적인 이름을 부여하여, 프로그램 전체가 이야기를 읽듯 술술 읽히는 것을 목표로 하자.

소프트웨어를 짜는 행위는 여느 글짓기와 비슷하다. 초안은 대개 서투르고 어수선하므로 원하는 대로 읽힐 때까지 말을 다듬고 문장을 고치고 문단을 정리한다.
Master programmer는 시스템을 (구현할) 프로그램이 아니라 (풀어갈) 이야기로 여긴다.

---

### Ch4: Comments

주석은 코드의 정보를 전달하는 데 있어 그 어떤 정보보다 유용하게 작용하기도 하고, 없는 것보다 못한 상황을 만들기도 한다.
그러나 꼭 기억해둬야 할 점이 있다면, 코드의 의도를 충분히 드러낼 수 있다면 주석이 없는 상태가 곧 최고의 상태라는 것이다. 
주석은 어디까지나 프로그래밍 언어만으로 의도를 표현하는 데 실패했을 때 이를 만회하기 위한 수단으로, 좋은 프로그래밍 습관을 위해서라면 
주석을 가능한 줄이도록 꾸준히 노력해야 한다.

- [ ] Are they necessary?

- [ ] Are the comments clear and useful?

- [ ] Do they explain the why, not the how?

```
• Comments do not make up for bad code
• Good comments 
  └ legal, informative, explains intent, clarification, Warning, TODO, amplification
• Bad comments
  └ mumbling, redundant, misleading, mandated, noise
• Don't use comment if there's a way with functions & variables
• No too much information
```

정보를 제공하거나, 의도를 설명하거나, 결과를 경고하거나, 중요성을 강조하는 등 사용함에 있어 유익한 결과를 불러오는 좋은 주석들도 존재한다.
그러나 이러한 내용을 작성할 때조차도 함수의 이름을 변경하는 등의 방식으로 주석을 사용하지 않고 코드만으로 같은 목적을 달성할 수 있다면, 주석의 사용은
지양하는 것이 좋다. 프로그래밍 실력이 미흡한 경우 더더욱 부실한 코드 구조를 주석의 설명으로 메꾸고자 나쁜 주석을 달게 되는 경우가 발생하기에, 
주석을 넣기 전에는 항상 그 필요성을 한 번 더 생각해보자.

또 한가지 생각해볼 점은 주석의 분량이다. 주석 또한 전체 프로그램 코드에서 자리를 차지하는 글귀이고, 코드를 보는 사람이 읽게 되는 부분이다.
주석의 길이가 길어질수록 전체 코드를 읽는 시간 또한 늘어지게 되고, clean code와 거리가 멀어지게 되는 건 당연하다.

코드의 내용을 설명하는 주석을 고민하는 대신에, 코드가 그 자체로 표현력을 가지도록 수정할 수 있는 방법을 고민해보자.
정말로 좋은 주석은, 주석을 달지 않을 방법을 찾아낸 주석이다.

---

### Ch7: Error Handling

오류 처리는 프로그램에 반드시 필요한 요소 중 하나로, 무언가 잘못되어 발생한 오류를 바로 잡을 책임은 프로그래머에게 있다.
그러나 이러한 오류 처리 코드는 수많은 위치에서 다양하게 동작해야 하기에, 복잡한 형태와 구조로 여기저기 분포해 있고, 
자칫 독자로 하여금 프로그램 논리를 이해하기 어렵게 만든다.
이런 상황을 방지하고 높은 안정성과 유지보수성을 지닌 clean code를 작성하기 위해, 오류 처리는 체계적인 방법 하에서 깔끔하게 이루어져야 한다.

오류 코드 대신 예외(Exception)를 사용하는 것은 가장 효과적인 오류 처리 방법이다. 이는 프로그램의 알고리즘과 
오류 처리 알고리즘을 분리하기에 읽기도 편하고 각 개념을 독립적으로 살펴보며 조정할 수 있다.

- [ ] Are exceptions used instead of error codes to handle errors?

- [ ] Are error messages clear and helpful for diagnosing issues?

- [ ] Are null values avoided in favor of throwing exceptions?

```
• Use exceptions rather than return codes
• Try-Catch-Finally statement
• Use unchecked exceptions
• Provide context with exceptions
• Don't return/pass Null
```

예외 사용 시 다음 사항을 고려하는 것이 유용하다. 메서드 선언과 함께 메서드가 반환할 예외를 모두 열거하는 형식의 
checked exception은 때로는 장점이 있지만, Open Closed Principle을 위반하는 구현이기에 일반적으로 바람직하지 못하다.
대부분의 경우 unchecked exception을 사용하는 편이 낫다. 또 한 가지는 null의 반환/전달을 피하라는 것이다. null의 사용을 
가정하게 되면 NullPointerException을 피하기 위해 모든 null 발생 가능 구간에서 이를 체크해주어야 하고, 이는 코드의 명료함과 안정성을 
크게 낮추게 된다.
