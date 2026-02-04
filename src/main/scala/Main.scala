object Main extends App {
  val defaultMessage = "Hello, world!"
  val cliMessage = args.headOption
  val propMessage = sys.props.get("hello.message")
  val envMessage = sys.env.get("HELLO_MESSAGE")
  val configMessage = {
    val config = com.typesafe.config.ConfigFactory.load()
    Option.when(config.hasPath("hello.message"))(config.getString("hello.message")).filter(_.nonEmpty)
  }
  val stdinMessage =
    Option.when(cliMessage.isEmpty && propMessage.isEmpty && envMessage.isEmpty && configMessage.isEmpty) {
      Option(scala.io.StdIn.readLine()).filter(_.nonEmpty)
    }.flatten
  val message = cliMessage
    .orElse(propMessage)
    .orElse(envMessage)
    .orElse(configMessage)
    .orElse(stdinMessage)
    .getOrElse(defaultMessage)
  println(message)
}
