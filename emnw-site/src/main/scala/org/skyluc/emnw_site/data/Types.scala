package org.skyluc.emnw_site.data

import org.skyluc.fan_resources.data as fr

trait WithProcessor extends fr.WithProcessor {

  override def process[T](processor: fr.Processor[T]): T = {
    processor match {
      case p: Processor[T] =>
        process(p)
      case _ =>
        ???
    }
  }

  def process[T](processor: Processor[T]): T
}

trait WithProcessorElement extends fr.WithProcessorElement {
  override def process[T](processor: fr.ProcessorElement[T]): T = {
    processor match {
      case p: ProcessorElement[T] =>
        process(p)
      case _ =>
        ???
    }
  }

  def process[T](processor: ProcessorElement[T]): T
}

trait Processor[T] extends fr.Processor[T] with ProcessorElement[T] {}

trait ProcessorElement[T] extends fr.ProcessorElement[T] {}
