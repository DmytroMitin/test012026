object Main extends App {
  val defaultMessage = "Hello, world!"
  val stdinMessage =
    Option.when(System.in.available() > 0) {
      scala.io.StdIn.readLine()
    }.filter(_.nonEmpty)
  val message = args.headOption
    .orElse(sys.props.get("hello.message"))
    .orElse(sys.env.get("HELLO_MESSAGE"))
    .orElse(stdinMessage)
    .getOrElse(defaultMessage)
  println(message)
}
