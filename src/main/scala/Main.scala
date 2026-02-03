object Main extends App {
  val defaultMessage = "Hello, world!"
  val cliMessage = args.headOption
  val propMessage = sys.props.get("hello.message")
  val envMessage = sys.env.get("HELLO_MESSAGE")
  val stdinMessage =
    Option.when(cliMessage.isEmpty && propMessage.isEmpty && envMessage.isEmpty) {
      Option(scala.io.StdIn.readLine()).filter(_.nonEmpty)
    }.flatten
  val message = cliMessage
    .orElse(propMessage)
    .orElse(envMessage)
    .orElse(stdinMessage)
    .getOrElse(defaultMessage)
  println(message)
}
