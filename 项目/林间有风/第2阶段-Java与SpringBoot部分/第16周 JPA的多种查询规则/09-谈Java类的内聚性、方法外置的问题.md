# 谈Java类的内聚性、方法外置的问题

现在我们做了两个转json的工具类，但是我们也失去了面向对象中类的优势，我们可以考虑到，类或者对象代表了我们业务逻辑的处理，然而List、Map让我们千变万化的类失去了他的业务意义

比如bannerService我们可以定义各种各样的业务逻辑，它是有特点的，比如bannerService和SpuService处理的业务逻辑是完全不同的

但是model中的spec变成了list或者map，那么他就是去了业务处理的能力。所以list、map并不是一个很好的表达业务类的方式。

假设之前test是一个类，我们把它变成map的话，那么他就不能拥有自己的业务方法了，因为他全都变成map了。

比如前端中定义的{key:value}，可以表达一个对象，为什么还需要class呢？class可以定义类的相关方法，前端有两种组织数据的形式。

但是后端如果将数据处理成map、list那就让类失去了本身能够处理业务的特性。类除了能够组织数据的形式，也要能完成业务。

如果一个类只有数据，没有行为方法，那就必须将这些方法外置。例如我们要处理spec，我们本可以将逻辑写在spec内部，当我们调用直接实例化spec然后调用即可，否则将spec作为参数传递。

