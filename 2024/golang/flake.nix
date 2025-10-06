# https://github.com/nix-community/nix-direnv?tab=readme-ov-file#creating-a-new-flake-native-project
{
  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixpkgs-unstable";
    flake-utils = {
      url = "github:numtide/flake-utils";
    };
    nix-utils = {
      url = "github:HoldenLucas/nix-utils";
    };
    gomod2nix = {
      url = "github:tweag/gomod2nix";
      inputs.nixpkgs.follows = "nixpkgs";
    };
  };

  outputs =
    {
      nixpkgs,
      flake-utils,
      nix-utils,
      gomod2nix,
      ...
    }:
    flake-utils.lib.eachDefaultSystem (
      system:
      let
        pkgs = nixpkgs.legacyPackages.${system}.extend (gomod2nix.overlays.default);

        scripts = nix-utils.lib.mkScripts pkgs (rec {
          dev = ''
            mprocs ",web-reload" ",styles-watch" ",templ-watch" ",templ-reload"
          '';
        });
        aoc-golang-2024 = pkgs.buildGoApplication {
          pname = "aoc-golang-2024";
          version = "0.1";
          pwd = ./.;
          src = ./.;
          modules = ./gomod2nix.toml;
        };

      in
      {
        devShells.default = pkgs.mkShell {

          packages =
            with pkgs;
            [
              go
              # shantis-app # TODO this builds slowly so direnv is a bad ux
            ]
            ++ scripts;
        };

      }
    );
}
