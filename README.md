## QR Sort: A Novel Non-Comparative Sorting Algorithm

### Java-implementation of a sort algorithm described in an [article](https://arxiv.org/pdf/2411.07526).

> [!NOTE]
> Java 7 compatible.

> [!CAUTION]
> Works only with natural numbers (including zero). Theoretically may be improved to work with all number sets (using inner number representation and some explicit array transformations) and for Strings as well, but what for?

Briefly: it is an improved Counting Sort, has a lot of limitations as well as Counting Sort.

To use the lib just import aleksei.vasilev.qrsort.QRSort wherever you need and pass an int array as an argument to the static QRSort.sort() method.
