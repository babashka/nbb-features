# nbb-features

A collection of premade features for [nbb](https://github.com/babashka/nbb)

## Intro

This repository aims to make it _easy_ to use libraries that nbb is not
currently able to evaluate through [SCI](https://github.com/babashka/sci). This
repository does this by providing premade features/libraries that can be pulled
in to a custom build of nbb.

## Usage

Use the features in this repository to build a custom nbb. Here are the steps for doing this:

1. In a new project, copy this repository's `bb.edn` and `package.json` files.
   * NOTE: The `:git/sha` for `nbb/nbb` may be old. You may want to update it to build the most recent version of nbb.
2. In `package.json`, rename the `nbb-features` references to make them your own.
3. In `bb.edn`, leave the nbb dependencies as those are needed for building nbb. As for the other dependencies, replace them with the features you want enabled. If the feature is local, use `:local/root` as seen in the copied `bb.edn`. If using a feature from this remote repository, pull them in like this:

  ```clojure
  :deps
  {datascript/deps
   {:git/url "https://github.com/babashka/nbb-features"
    :git/sha "7af8569a7f932af2cde5f8677133915540ab0c49"
    :deps/root "features/datascript"}
   }
  ```

4. Build your custom nbb with `bb release`. Run `node lib/nbb_main.js` and your nbb with custom features enabled will run!

## Features

The following libraries are provided as features:
* https://github.com/tonsky/datascript
* https://github.com/tonsky/datascript-transit
* https://github.com/frankiesardo/linked

NOTE: These features usually provide a subset of a library's API to nbb. To see what library fns are available, see the feature's sci configuration.

## Contributing

To contribute a new feature, please add a new feature under `features/` and corresponding tests under `test/features/`. See [this doc](https://github.com/babashka/nbb/blob/main/doc/dev.md#features) for what's required to make a feature. Before contributing a feature, make sure that the library doesn't already work with nbb and SCI. If your nbb feature was useful to you, we'd love to have it as a contribution!

## Additional Links

* https://github.com/logseq/nbb-logseq

## License

Distributed under the EPL License. See LICENSE.
