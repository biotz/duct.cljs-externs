# Duct module.cljs

[![Clojars Project](https://img.shields.io/clojars/v/coop.magnet.duct-module/cljs-externs.svg)](https://clojars.org/coop.magnet.duct-module/cljs-externs)

A [Duct][] module that adds support for managing [externs][] for third
party JavaScript libraries when compiling ClojureScript for
production.

The default [:duct.module/cljs][] configuration for the CLJS compiler
does not include any externs definitions. The only way to add them to
the CLJS compiler options is by using the [:duct.compiler/cljs][]
Integrant keys directly in the `config.edn` file for the production
environment.

But this has the unintended side-effect of running the CLJS compiler
even in the development environment, as the CLJS Integrant keys are
inherited in the development environment.

This module allows us to:

* just specify the externs for the third party libraries, instead of
  the full `:builds` configuration map; these are merged with the
  configuration map produced by `:duct.module/cljs` module)

* apply the resulting CLJS configuration only for the production
  environment, avoiding any unnecessary compilation in the development
  environment.

[duct]: https://github.com/duct-framework/duct
[externs]: https://clojurescript.org/guides/externs
[:duct.module/cljs]: https://github.com/duct-framework/module.cljs
[:duct.compiler/cljs]: https://github.com/duct-framework/compiler.cljs

## Installation

To install, add the following to your project `:dependencies`:

    [coop.magnet.duct-module/cljs-externs "0.1.0"]

## Usage

To add this module to your configuration, add the
`:coop.magnet.duct-module/cljs-externs` key to your configuration. You
will need to specify the path to your externs definitions files via
the `:externs` key, using a vector.

As of [Duct core][] 0.6.2, the module application sequence is not
always the module dependency order (this is expected to be changed in
the upcoming 0.7.0 version). This module expects that the
`:duct.module/cljs` module has already been applied for it to work
correctly. So as of now, you also need to pass a reference to the
`:duct.module/cljs` key, using the `:cljs-module` key. This
requirement should disappear in the future:

```edn
 :coop.magnet.duct-module/cljs-externs {:cljs-module #ig/ref :duct.module/cljs
                                        :externs ["src/aluminium/js/externs.js"]}
```

[Duct core]: https://github.com/duct-framework/core

## License

Copyright (c) 2018, 2019 Iñaki Arenaza & Magnet S. Coop.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
